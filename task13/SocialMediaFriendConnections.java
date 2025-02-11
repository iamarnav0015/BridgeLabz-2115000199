import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List of Friend IDs
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }

    public void addFriend(int friendId) {
        if (!friendIds.contains(friendId)) {
            friendIds.add(friendId);
        }
    }

    public void removeFriend(int friendId) {
        friendIds.remove(Integer.valueOf(friendId));
    }
}

public class SocialMediaFriendConnections {
    private UserNode head;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    // Find a user by User ID
    private UserNode findUserById(int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.addFriend(userId2);
        user2.addFriend(userId1);
        System.out.println("Friend connection added between User " + userId1 + " and User " + userId2);
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.removeFriend(userId2);
        user2.removeFriend(userId1);
        System.out.println("Friend connection removed between User " + userId1 + " and User " + userId2);
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>();
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }

        System.out.println("Mutual friends between User " + userId1 + " and User " + userId2 + ": " + mutualFriends);
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of User " + userId + ": " + user.friendIds);
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, int userId) {
        UserNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.name.equalsIgnoreCase(name) || current.userId == userId) {
                System.out.println("User found: ID=" + current.userId + ", Name=" + current.name + ", Age=" + current.age);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No user found with Name='" + name + "' or ID=" + userId);
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode current = head;
        while (current != null) {
            System.out.println("User " + current.userId + " has " + current.friendIds.size() + " friends.");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaFriendConnections smfc = new SocialMediaFriendConnections();

        // Adding users
        smfc.addUser(101, "Alice", 25);
        smfc.addUser(102, "Bob", 30);
        smfc.addUser(103, "Charlie", 28);

        // Adding friend connections
        smfc.addFriendConnection(101, 102);
        smfc.addFriendConnection(101, 103);

        // Display friends
        smfc.displayFriends(101);
        smfc.displayFriends(102);

        // Search for users
        smfc.searchUser("Alice", 0);
        smfc.searchUser("", 103);

        // Mutual friends
        smfc.findMutualFriends(101, 102);

        // Remove friend connection
        smfc.removeFriendConnection(101, 102);

        // Display friends after removal
        smfc.displayFriends(101);

        // Count number of friends for each user
        smfc.countFriends();
    }
}
