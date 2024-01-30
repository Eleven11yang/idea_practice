package study.practice.hm3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.objectweb.asm.*;

public class ElephantService {
    static void saveToTxtFile(Elephant elephant) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("elephants.txt", true))) {
            // 将Elephant对象的JSON字符串表示形式附加到文件中
            writer.write(elephant.toJson().toJSONString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList getElephantsJson(String filePath) {
        Set<String> elephantSet = new HashSet<>();
        ArrayList jsonList = new ArrayList();
        // 读取文件并添加到 HashSet 中
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                JSONObject jsonObject = JSON.parseObject(line);
                String name = jsonObject.getString("name");
                if (elephantSet.contains(name) == false) {
                    elephantSet.add(name);
                    jsonList.add(jsonObject);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonList;
    }

    static byte[] changeHashCodeWithBooleanMembers() {
        Elephant elephant = new Elephant();
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "ElephantHashCode", null, "java/lang/Object", null);

        cw.visitField(Opcodes.ACC_PRIVATE, "name", "Ljava/lang/String;", null, null);
        cw.visitField(Opcodes.ACC_PRIVATE, "isFridgeOpen", "Z", null, null);
        cw.visitField(Opcodes.ACC_PRIVATE, "isElephantInside", "Z", null, null);
        cw.visitField(Opcodes.ACC_PRIVATE, "isFridgeLocked", "Z", null, null);

        // 构造函数
        MethodVisitor constructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "(Ljava/lang/String;ZZZ)V", null, null);
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitVarInsn(Opcodes.ALOAD, 1);
        constructor.visitFieldInsn(Opcodes.PUTFIELD, "ElephantHashCode", "name", "Ljava/lang/String;");
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitVarInsn(Opcodes.ILOAD, 2);
        constructor.visitFieldInsn(Opcodes.PUTFIELD, "ElephantHashCode", "isFridgeOpen", "Z");
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitVarInsn(Opcodes.ILOAD, 3);
        constructor.visitFieldInsn(Opcodes.PUTFIELD, "ElephantHashCode", "isElephantInside", "Z");
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitVarInsn(Opcodes.ILOAD, 4);
        constructor.visitFieldInsn(Opcodes.PUTFIELD, "ElephantHashCode", "isFridgeLocked", "Z");
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(5, 5);
        constructor.visitEnd();

        // hashCode 方法
        MethodVisitor hashCodeMethod = cw.visitMethod(Opcodes.ACC_PUBLIC, "hashCode", "()I", null, null);
        hashCodeMethod.visitCode();

        // 字符串哈希码
        hashCodeMethod.visitVarInsn(Opcodes.ALOAD, 0);
        hashCodeMethod.visitFieldInsn(Opcodes.GETFIELD, "ElephantHashCode", "name", "Ljava/lang/String;");
        hashCodeMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "hashCode", "()I", false);

        // 布尔值哈希码
        hashCodeMethod.visitVarInsn(Opcodes.ALOAD, 0);
        hashCodeMethod.visitFieldInsn(Opcodes.GETFIELD, "ElephantHashCode", "isFridgeOpen", "Z");
        hashCodeMethod.visitVarInsn(Opcodes.ALOAD, 0);
        hashCodeMethod.visitFieldInsn(Opcodes.GETFIELD, "ElephantHashCode", "isElephantInside", "Z");
        hashCodeMethod.visitVarInsn(Opcodes.ALOAD, 0);
        hashCodeMethod.visitFieldInsn(Opcodes.GETFIELD, "ElephantHashCode", "isFridgeLocked", "Z");

        // 布尔值的哈希码计算：true=1231, false=1237
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label end = new Label();
        hashCodeMethod.visitInsn(Opcodes.ICONST_0);
        hashCodeMethod.visitJumpInsn(Opcodes.IFNE, l1);
        hashCodeMethod.visitInsn(Opcodes.ICONST_5);
        hashCodeMethod.visitJumpInsn(Opcodes.GOTO, l2);
        hashCodeMethod.visitLabel(l1);
        hashCodeMethod.visitInsn(Opcodes.ICONST_3);
        hashCodeMethod.visitJumpInsn(Opcodes.GOTO, l3);
        hashCodeMethod.visitLabel(l2);
        hashCodeMethod.visitInsn(Opcodes.IXOR);
        hashCodeMethod.visitJumpInsn(Opcodes.GOTO, end);
        hashCodeMethod.visitLabel(l3);
        hashCodeMethod.visitInsn(Opcodes.IXOR);
        hashCodeMethod.visitInsn(Opcodes.IXOR);
        hashCodeMethod.visitJumpInsn(Opcodes.GOTO, end);
        hashCodeMethod.visitLabel(end);

        // 返回结果
        hashCodeMethod.visitInsn(Opcodes.IADD);
        hashCodeMethod.visitInsn(Opcodes.IRETURN);
        hashCodeMethod.visitMaxs(4, 1);
        hashCodeMethod.visitEnd();

        cw.visitEnd();
        return cw.toByteArray();
    }

    static void changeHashCodeWithoutBooleanMembers() {

    }
}

