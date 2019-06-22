
public class TestTrie {

	public static void main(String[] args) {
		
		Trie t = new Trie();
		t.insert("abcd");
		t.insert("abcshk");
		t.insert("abc");
		t.insert("qwert");
		t.insert("qwsdf");
		t.insert("asdfg");
		
		System.out.println(t.search("abc"));
		System.out.println(t.search("abce"));
		System.out.println(t.search("ab"));

		
	}
}
