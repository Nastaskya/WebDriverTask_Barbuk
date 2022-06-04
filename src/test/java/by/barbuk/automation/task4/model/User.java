package by.barbuk.automation.task4.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    @NonNull
    private String emailAddress;
    private String firstName;
    private String lastName;
}
