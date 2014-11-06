package JokesServer.Model;

import JokesServer.Model.JokesIDL.JokesPOA;

import java.util.Random;

/*
 * 
 * @author Jbo
 * 
 */
public class JokesImpl extends JokesPOA {

    private String[] jokes = {

"Q: How does a computer tell you it needs more memory?\nA: It says \"byte me\"",
"How many Microsoft technicians does it take to screw in a light bulb?\nNone, they would just declare darkness the new standard TM",
"Trust me, I\'m neither \"micro,\" nor \"soft.\"",
"What is the first programming language you learn when studying computer science?\nProfanity",
"Q: Why did the blonde quit her restroom attendant job?\nA: She couldn't figure out how to refill the hand dryer.",
"If I could rearrange the alphabet, I would put \"U\" and \"I\" together. And it would stand for \"user interface.\"",
"What is your sign? Mine is \"Property of NASA.\"",
"Who invented the first computer in Biblical Times?\nEve -- she had an Apple in one hand and a Wang in the other!",
"Did you hear about the new Mike Tyson Computer?\nIt has two bytes and no memory.",
"How is a computer like Britney Spears?\nThey're both cheap, white, and plastic.",
"A blonde complains to a brunette friend that her Internet is down.\nThe brunette friend offers to let the blonde check her e-mail at her house.\n\"That\'s OK\" says the blonde. \"Why don\'t you check it and forward me what I got?\"",
"Most people believe that if it ain\'t broke, don\'t fix it.\nEngineers believe that if it ain\'t broke, it doesn\'t have enough features yet.",
"What does a blonde do when her computer freezes?\nShe sticks it in the microwave.",
"Your bra size looks like it's the same as my favorite computer language, C++.",
"Q: What do you get when you cross a gorilla and a computer?\nA: Hairy Reasoner.",
"Q: What\'s the difference between a woman and a computer?\nA: You can't upgrade woman for 50$",
"Q: What\'s the difference between an Linux and a virus?\nA: A virus does something.",
"Macs are for those who don\'t want to know why their computer works.\nLinux is for those who want to know why their computer works.\nDOS is for those who want to know why their computer doesn't work.\nWindows is for those who don't want to know why their computer doesn't work.",
"Artificial intelligence usually beats real stupidity.",
"CAPS LOCK: Preventing Login Since 1980.",
"My software never has bugs. It just develops random features",
"The beginning of the programmers wisdom is understanding the difference between getting program to run and having a runnable program",
"Michael Sinz: \"Programming is like sex, one mistake and you have to support it for the rest of your life.\"",
"If you give someone a program, you will frustrate them for a day: if you teach them how to program, you will frustrate them for a lifetime.",
"My attitude isn\'t bad. It\'s in beta",
"Programmers are tools for converting caffeine into code.",
"1f u c4n r34d th1s u r34lly n33d t0 g37 l41d.",
"What's the difference between a lawyer and God?\nGod doesn\'t think he\'s a lawyer",
"Q: Why is a laundromat a really bad place to pick up women?\nA: Because a woman who can't afford her own washing machine won't be able to support you.",
"Q: What has a bunch of little balls and screws old ladies?\nA: A bingo machine.",
"Q: What does a blonde say after having multiple orgasms?\nA: Great work, team!",
"Q: What do a tornado and a redneck divorce have in common?\nA: In the end, someone is going to lose a trailer",
"Q: How do you stop a lawyer from drowning?\nA: Shoot him before he hits the water.",
"Rednecks don\'t let friends drive home drunk, they get drunk and ride with them."};
    
    
    Random generator = new Random();

    public JokesImpl()
    {
    	
	}

	@Override
    public String send_joke()
	{
        String ret = getRandom(jokes);
        return ret;

    }

    private String getRandom(String[] jokes) {
        int rnd = generator.nextInt(jokes.length);
        System.out.println(rnd);
        return jokes[rnd];
    }
}