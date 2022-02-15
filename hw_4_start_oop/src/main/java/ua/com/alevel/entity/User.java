package ua.com.alevel.entity;

public record User(
        String id,
        String email,
        String login,
        String password,
        Role role) {

    @Override
    public String toString() {
        return String.format("%15s %15s %15s %6s", email, login, password, role);
    }
}
