package com.atguigu.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class T1 {

	public static void main(String[] args) {
	        List<String> wordList = Arrays.asList("abc","mdw","ket");
	        Stream<String> words = wordList.stream();
	        //注意下面两句
//	        Stream<Stream<Character>> lowercaseWords = words.map(T1::characterStream);
//	        lowercaseWords.forEach(stream -> stream.forEach(System.out::print));
	        //再次注意下面两句
	        Stream<Character> lowercaseWords = words.flatMap(T1::characterStream);
	        lowercaseWords.forEach(System.out::print);
	    }
	    public static Stream<Character> characterStream(String s) {
	        List<Character> result = new ArrayList<>();
	        //Stream<T>，T必须是类类型，基本类型不可以
	        for(char c:s.toCharArray()) result.add(Character.valueOf(c));
	        return result.stream();
	    }
}
