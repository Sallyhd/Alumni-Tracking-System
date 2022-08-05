package miu.edu.AlumniTrackingSystem.service;

public interface UserService<T> {
    void register(T newUser);
    void editProfile(T user);
}
