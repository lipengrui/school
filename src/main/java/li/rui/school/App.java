package li.rui.school;

import java.io.Console;

import util.AudioUtils;
import util.MP3ConvertPCM;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
        	AudioUtils utils  = AudioUtils.getInstance();
            utils.convertMP32Pcm("D:\\WORK\\cocos\\school\\resource\\test.mp3", "D:\\WORK\\cocos\\school\\resource\\test.pcm");
//			MP3ConvertPCM.mp3Convertpcm("D:\\WORK\\cocos\\school\\resource\\test.mp3", "D:\\WORK\\cocos\\school\\resource\\test.pcm");
		} catch (Exception e) {
			System.out.println("error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
