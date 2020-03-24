package com.myquest.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://www.hackerrank.com/challenges/tag-content-extractor/problem
 */
public class TagContentExtractor {

	public static void main(String[] args) throws Exception {
		
//		String str = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>";
		String str[] = {
				
				"<h1>some</h1>",
				"<h1>had<h1>public</h1></h1>",
				"<h1>had<h1>public</h1515></h1>",
				"<h1><h1></h1></h1>",
				"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<",
				">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",
				"<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>",
				"<>hello</>",
				"<>hello</><h>dim</h>",
				"<>hello</><h>dim</h>>>>>"
		};
		
			
		List<String> list = new ArrayList<>(); 
		for(int i=0; i<str.length; i++) {
			System.out.println("---- processing: " + str[i]);
			list.addAll(extractTagContent(str[i]));
		}
		
		list.forEach(s -> System.out.println(s));
			
//		System.out.println("   tags: " + tags);
//		System.out.println("invTags: " + invTags);

	}
	
	private static List<String> extractTagContent(String str) {
		
		List<String> list = new ArrayList<>();
		int start = 0;
		boolean startFlag = false;
		String currTag = "";
		boolean currTagFlag = false;
		int t;
		
		int i = 0;
		int count = 0;
		
		while(i < str.length()) {
			
			t = str.indexOf('<', i);
			if(t < 0) {
				break;
			}
			// System.out.println("found start tag at: " + t);
			if(t < str.length() - 2 
					&& str.charAt(t + 1) != '/'
					&& str.charAt(t + 1) != '>') {
				start = t;
				i = t;
				
				t = str.indexOf('>', i);
				if(t != -1) {
					currTag = str.substring(start, t + 1);
					addToTagList(currTag);
					currTagFlag = true;					
					i = t + 1;
				} else {
					break;
				}
			} else {
				i++;
			}
			
			if(currTagFlag) {
				t = str.indexOf('<', i);
				if(t < 0) {
					break;
				}
				/*System.out.println("  found end tag at: " + t 
						+ ", currTag: " + currTag 
						+ ", inv(currTag): " + tags.get(currTag) 
						+ ", index: " + str.indexOf(tags.get(currTag)));*/
				if(t > i && t == str.indexOf(tags.get(currTag))) {
					list.add(str.substring(start + currTag.length(), t));
//					System.out.println(list.get(list.size()-1));
					i = t + tags.get(currTag).length();
				} else {
					i = t;
				}
				currTagFlag = false;
			}
			
//			System.out.printf("i: %d\n", i);
		}
		
		if(list.isEmpty()) {
			list.add("None");
		}
		
		return list;
	}
	
	static Map<String, String> tags = new HashMap<>();
	static Map<String, String> invTags = new HashMap<>();
	
	private static void addToTagList(String tag) {
		if(tag.startsWith("<") && tag.endsWith(">")) {
			tags.put(tag, "</"+tag.substring(1, tag.length()-1)+">");
			invTags.put("</"+tag.substring(1, tag.length()-1)+">", tag);
		}
	}

	
}

