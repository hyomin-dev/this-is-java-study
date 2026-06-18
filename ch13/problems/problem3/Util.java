package ch13.problems.problem3;

public class Util {

	// 매개변수로 Pair 객체 또는 자식 객체만 오도록 됨

	/*
	 * public static <K, V> V getValue(Pair<K,V> pair, K key){
	 * if(key.equals(pair.getKey())) return pair.getValue(); else return null; }
	 */

	// 제한된 타입 파라미터

	
	  public static <P extends Pair<K, V>,K, V> V getValue(P p, K k) {
	  if(p.getKey().equals(k)) return p.getValue(); else return null;
	  
	  }
	 

}
