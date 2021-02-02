package com.xbd.pushdata.test;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.LambdaUtil;

public class Test {
	public static void printValur(String str) {
		System.out.println("print value : " + str);
	}

	public static void main(String[] args) {
		List<String> al = Arrays.asList("a", "b", "c", "d","e");
		//(1)方法一：
		al.forEach(Test::printValur);
		//(2)方法二：
		// 下面的方法和上面等价的
		Consumer<String> methodParam = Test::printValur; // 方法参数
		al.forEach(x -> methodParam.accept(x));// 方法执行accept
	}
}
@Data
class Student {
	private String name;
	private String sex;
}
