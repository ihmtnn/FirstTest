package cn.itcast.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionTest {

    @Test
    public void testMd5Hash(){
        Md5Hash md1 = new Md5Hash("123", "ha", 2);
        System.out.println(md1);
        Md5Hash md2 = new Md5Hash("123");
        System.out.println(md2);
    }

    @Test
    public void testBCrypt(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        //System.out.println(encode);
        //$2a$10$iFar92KbqLtWKDhAN9U.repbQmhJwAaZg32rVNJ3YFZ2Jyo9l9UUi
        //$2a$10$TvL9g8i5Lx2afxwpf7ZBee8fDznDgKLYwLk8kmVGkTVX6kxxnWKFi
        //执行再次加密的结果不一样但是都是可以匹配上rawPassword的
        System.out.println(encoder.matches("123456", "$2a$10$iFar92KbqLtWKDhAN9U.repbQmhJwAaZg32rVNJ3YFZ2Jyo9l9UUi"));
        System.out.println(encoder.matches("123456", "$2a$10$TvL9g8i5Lx2afxwpf7ZBee8fDznDgKLYwLk8kmVGkTVX6kxxnWKFi"));
        //都他妈是true
    }


}
