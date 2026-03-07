package com.example.signupform;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        if (userRepository.count() == 0) {

            userRepository.save(new User("101", "Shatakshi", "abc@gmail.com", "1234"));
            userRepository.save(new User("102", "Rahul", "rahul@gmail.com", "5678"));
            userRepository.save(new User("103", "Priya", "priya@gmail.com", "9999"));

            System.out.println("Default users inserted");
        }
    }
}
