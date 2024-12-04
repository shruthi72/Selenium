package Streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Listnames {
	public static void main(String[] args)
	{
		//streamFilter();
		//streamMap();
		streamCollect();
	}
	public void regular() {
		// TODO Auto-generated method stub
		ArrayList<String> names=new ArrayList<String>();
		names.add("First");
		names.add("Second");
		names.add("Third");
		names.add("Four");
		int count=0;
		for(int i=0;i<names.size();i++)
		{
			String actual= names.get(i);
			if(actual.startsWith("F"))
			{
				count++;
			}
		}
		System.out.println(count);

	}
	public static void streamFilter()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("First");
		names.add("Second");
		names.add("Third");
		names.add("Four");
		//there is no life for intermediate operation if here is no terminal operation
		//terminal operation will execute only if intermediate operation(filter) returns true
		Long c=names.stream().filter(s->s.startsWith("F")).count(); 
		//converting string to stream and in filter used lambda expression. count method data type is long
		//Lambda Expression Syntax: Left side parameter name -> right side actions
		System.out.println(c);
		
		//Create stream directly
		long d=Stream.of("First","Second","Third","Fourth").filter(s->
		{
			s.startsWith("F");
			return true;//if return is false below count() will not be executed
		}).count();
		System.out.println(d);
		//Print all the names of ArrayList using stream
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		//for same scenario of line 49 if you want limit the result use below
		//names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}
	public static void streamMap()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("ABCD");
		names.add("ZXY");
		names.add("MNOP");
		
		//print names of length>4 with uppercase
		Stream.of("First","Second","Third","Fourth").filter(s->s.endsWith("d")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names which has first letter as a with uppercase and sorted
		//Line 62 is converting arrays to array list
		List<String>names1=Arrays.asList("First","Second","Third","Fourth");
		names1.stream().filter(s->s.startsWith("F")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merging 2 different lists
		Stream<String> newStream=Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		
		//checking name is present or not by getting output as True or False using anyMatch
		boolean flag =newStream.anyMatch(s->s.equalsIgnoreCase("first"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	public static void streamCollect()
	{
		List<String> ls=Stream.of("First","Second","Third","Fourth").filter(s->s.endsWith("d")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		ls.get(0);
		
		List<Integer> values=Arrays.asList(3,2,2,7,5,1,9,7);
		//Print unique number from this array
		System.out.println("Unique numbers are:");
		values.stream().distinct().forEach(s->System.out.println(s));
		
		//Sort the array
		System.out.println("Sorted array:");
		List<Integer> newli=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newli.get(3));
	}

}

	
