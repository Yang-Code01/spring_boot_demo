package com.arrayExe.cas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author code-yang
 * @date 2021/9/6 15:50
 * @Description
 * @Return
 * @Throws
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
class User{

    private String name;
    // age
    private Integer age;

}

/**
 * @author AVTNTW672
 * 原子引用，将自定义类，包装成原子类
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User zs = new User("zs", 11);
        User ls = new User("ls",13);

        AtomicReference<User> userAtomicReference = new AtomicReference<>();

        userAtomicReference.set(zs);
        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get());
        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get());


    }
}
