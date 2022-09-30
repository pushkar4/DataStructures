
public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {

    TrieNode curr = root;
    char c;

    for (int i = 0; i < word.length(); i++) {
      c = word.charAt(i);
      if (curr.childMap.containsKey(c)) {
        curr = curr.childMap.get(c);
      } else {
        TrieNode node = new TrieNode();
        curr.childMap.put(c, node);
        curr = node;
      }
    }
    curr.endOfWord = true;
  }

  public boolean search(String word) {

    TrieNode curr = root;
    char c;

    for (int i = 0; i < word.length(); i++) {
      c = word.charAt(i);
      if (curr.childMap.containsKey(c)) {
        curr = curr.childMap.get(c);
      } else {
        return false;
      }
    }

    if (curr.endOfWord)
      return true;
    else
      return false;
  }

  public void remove(String word) {

  }
}
