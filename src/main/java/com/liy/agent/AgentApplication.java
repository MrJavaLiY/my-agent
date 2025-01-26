package com.liy.agent;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

/**
 * agentTest 类的简要描述
 *
 * @author liyang
 * @since 2025/1/25
 */
public class AgentApplication {

    // premain 方法：当 JVM 启动时调用
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Agent loaded at JVM startup.");
        inst.addTransformer(new LineMonitorClassFileTransformer());
    }

    // agentmain 方法：当 JVM 已经启动后调用
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("Agent loaded at runtime.");
        inst.addTransformer(new LineMonitorClassFileTransformer());
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
    }
}
