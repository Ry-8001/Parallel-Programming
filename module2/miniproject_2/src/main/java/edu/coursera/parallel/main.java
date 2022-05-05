package edu.coursera.parallel;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {

    public static void main(String[] args) {
        Student s0=new Student("ramo","yeto",23.0,10,false);
        Student s1=new Student("ramo1","yeto1",23.0,10,false);
        Student s2=new Student("ramo","yeto",23.0,10,false);
        Student s3=new Student("ramo2","yet2",25.0,10,false);

        Student arr[] = new Student[4];
        arr[0]=s0;arr[1]=s1;arr[2]=s2;arr[3]=s3;



                String  a=Stream.of(arr).parallel().filter(s->!s.checkIsCurrent()).
                collect(Collectors.groupingBy(Student::getFirstName,Collectors.counting())).
                entrySet()
                .stream().parallel()
                .max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
        System.out.println(a);
    }
}
