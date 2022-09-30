import java.util.HashMap;
import java.util.Map;

public class TrieNode {

  Map<Character, TrieNode> childMap;
  boolean endOfWord;

  public TrieNode() {
    endOfWord = false;
    childMap = new HashMap<Character, TrieNode>();
  }
}
