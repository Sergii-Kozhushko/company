package main;

import lombok.Getter;

@Getter
public enum Rating {
    A(20),
    B(15),
    C(5),
    D(0),
    E(-5);
    final int value;

    Rating(int value) {
        this.value = value;
    }

}
