class Solution {
    public String defangIPaddr(String address) {
        // Replace all occurrences of "." with "[.]"
        return address.replace(".", "[.]");
    }
}
