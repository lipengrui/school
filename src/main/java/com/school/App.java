package com.school;



import java.io.Console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

import com.school.util.AudioUtils;
import com.school.util.MP3ConvertPCM;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScans({@ComponentScan("com.**.controller")})
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
//        try {
//        	AudioUtils utils  = AudioUtils.getInstance();
//            utils.convertMP32Pcm("D:\\WORK\\cocos\\school\\resource\\test.mp3", "D:\\WORK\\cocos\\school\\resource\\test.pcm");
////			MP3ConvertPCM.mp3Convertpcm("D:\\WORK\\cocos\\school\\resource\\test.mp3", "D:\\WORK\\cocos\\school\\resource\\test.pcm");
//		} catch (Exception e) {
//			System.out.println("error");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
}
