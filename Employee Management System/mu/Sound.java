package mu;

/*
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
*/

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;
import sun.audio.*;
import javax.sound.sampled.*;
import javax.sound.*;



public class Sound  {



public static void recordexists(){
try{

String songFile = "Recordexists.wav";
InputStream in= new FileInputStream(songFile);

AudioStream audioStream = new AudioStream(in);


AudioPlayer.player.start(audioStream);

 

}//end of try

catch(Exception e){
System.out.print(e);
}

}//end of success method




public static void recordadded(){
try{

String songFile = "Recordadded.wav";
InputStream in= new FileInputStream(songFile);

AudioStream audioStream = new AudioStream(in);
AudioPlayer.player.start(audioStream);

}
catch(Exception e){
System.out.print(e);
}

}



public static void recordnotfound(){
try{

String songFile = "Recordnotfound.wav";
InputStream in= new FileInputStream(songFile);

AudioStream audioStream = new AudioStream(in);
AudioPlayer.player.start(audioStream);

}
catch(Exception e){
System.out.print(e);
}

} 





public static void allfieldsmandatory(){
try{

String songFile = "Allfieldsmandatory.wav";
InputStream in= new FileInputStream(songFile);

AudioStream audioStream = new AudioStream(in);
AudioPlayer.player.start(audioStream);

}
catch(Exception e){
System.out.print(e);
}

}





public static void updaterecord(){
try{

String songFile = "Updaterecord.wav";
InputStream in= new FileInputStream(songFile);

AudioStream audioStream = new AudioStream(in);
AudioPlayer.player.start(audioStream);

}
catch(Exception e){
System.out.print(e);
}

}


public static void validnumber(){
try{

String songFile = "Validnumber.wav";
InputStream in= new FileInputStream(songFile);

AudioStream audioStream = new AudioStream(in);
AudioPlayer.player.start(audioStream);

}
catch(Exception e){
System.out.print(e);
}

}




public static void validname(){
try{

String songFile = "Validname.wav";
InputStream in= new FileInputStream(songFile);

AudioStream audioStream = new AudioStream(in);
AudioPlayer.player.start(audioStream);

}
catch(Exception e){
System.out.print(e);
}

}


public static void recorddelete(){
try{

String songFile = "Recorddelete.wav";
InputStream in= new FileInputStream(songFile);

AudioStream audioStream = new AudioStream(in);
AudioPlayer.player.start(audioStream);

}
catch(Exception e){
System.out.print(e);
}

}



}




