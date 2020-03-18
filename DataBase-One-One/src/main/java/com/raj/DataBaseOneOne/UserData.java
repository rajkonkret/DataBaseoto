package com.raj.DataBaseOneOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/* gdy nie ma adnotacjo Component to Spring ignoruje tą klase

 */
@Component
public class UserData implements CommandLineRunner {
    // generowana jest klasa która implementuje interfejs i robi sql
    @Autowired
    private UserRepository userRepository;

    //ta metoda odpali się po starcie serwera pod warunkiem ze klasa będzie miała adnotację @Component
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("raj@raj.pl");
        user.setUsername("radek");

        UserDetails userDetails = new UserDetails();
        userDetails.setAddress("Opole");
        userDetails.setPesel("750827");
        user.setUserDetails(userDetails);

        userRepository.save(user);

        UserDetails userDetails2 = new UserDetails();
        userDetails2.setAddress("Wawa");

        User user2 = new User();
        user2.setEmail("rajkonkret@raj.pl");
        user2.setUsername("badek");
        user2.setUserDetails(userDetails2);
        userRepository.save(user2);

    }
}
