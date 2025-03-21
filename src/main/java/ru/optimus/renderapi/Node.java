package ru.optimus.renderapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Node {
    private int instruction;
    private Option option;

    public static Node of(int instruction, Option option){
        return new Node(instruction, option);
    }

}