import java.util.*;

class ThroneInheritance {
    private String king;
    private Map<String, List<String>> childrenMap;
    private Set<String> deadSet;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.childrenMap = new HashMap<>();
        this.deadSet = new HashSet<>();
        // Initialize the king's children list
        this.childrenMap.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        // Add the child to the parent's list of children
        childrenMap.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        // Mark person as dead without removing them from the tree structure
        deadSet.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // Add to result if the person is alive
        if (!deadSet.contains(current)) {
            order.add(current);
        }

        // Recursively visit children in order of birth
        List<String> children = childrenMap.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_4 = obj.getInheritanceOrder();
 */
