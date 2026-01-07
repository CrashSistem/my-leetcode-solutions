class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            int atIndex = email.indexOf('@');
            String localPart = email.substring(0, atIndex);
            String domainPart = email.substring(atIndex);
            int plusIndex = localPart.indexOf('+');
            if (plusIndex != -1) {
                localPart = localPart.substring(0, plusIndex);
            }
            localPart = localPart.replaceAll("\\.", "");

            uniqueEmails.add(localPart + domainPart);
        }
        return uniqueEmails.size();
    }
}
