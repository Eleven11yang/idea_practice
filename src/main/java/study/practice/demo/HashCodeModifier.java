package study.practice.demo;

import org.objectweb.asm.*;

public class HashCodeModifier {
    public static byte[] modifyHashCode(byte[] classBytes) {
        ClassReader classReader = new ClassReader(classBytes);
        ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);

        classReader.accept(classVisitor, 0);

        return classWriter.toByteArray();
    }

    static class MyClassVisitor extends ClassVisitor {
        public MyClassVisitor(ClassVisitor classVisitor) {
            super(Opcodes.ASM8, classVisitor);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            // 检测到 hashCode 方法
            if ("hashCode".equals(name) && "()I".equals(descriptor)) {
                MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);

                // 在 hashCode 方法的起始插入打印语句
                methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                methodVisitor.visitLdcInsn("HashCode modified!");
                methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

                // 继续访问原始的 hashCode 方法
                return new MyMethodVisitor(methodVisitor);
            }

            return super.visitMethod(access, name, descriptor, signature, exceptions);
        }
    }

    static class MyMethodVisitor extends MethodVisitor {
        public MyMethodVisitor(MethodVisitor methodVisitor) {
            super(Opcodes.ASM8, methodVisitor);
        }

        @Override
        public void visitInsn(int opcode) {
            // 在原始方法的返回前插入打印语句
            if (opcode == Opcodes.IRETURN) {
                super.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                super.visitLdcInsn("Returning HashCode!");
                super.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            }

            super.visitInsn(opcode);
        }
    }
}
