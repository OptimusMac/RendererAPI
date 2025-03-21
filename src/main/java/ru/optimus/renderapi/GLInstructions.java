package ru.optimus.renderapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GLInstructions {

    private final List<Node> appliedNodes = new ArrayList<>();
    private Node[] instructions;

    public static GLInstructions of(Node... nodes) {
        return new GLInstructions(nodes);
    }

    public static GLInstructions empty() {
        return new GLInstructions(new Node[0]);
    }

    public boolean isEmpty() {
        return instructions.length == 0;
    }

    public void enableAll() {
        for (Node instruction : instructions) {
            if (instruction.getOption() == Option.ENABLE) {
                GL11.glEnable(instruction.getInstruction());
            } else {
                GL11.glDisable(instruction.getInstruction());
            }
            appliedNodes.add(instruction);
        }
    }

    public void flush() {
        for (Node appliedNode : appliedNodes) {
            if (appliedNode.getOption() == Option.DISABLE) {
                GL11.glEnable(appliedNode.getInstruction());
            } else {
                GL11.glDisable(appliedNode.getInstruction());
            }
        }
    }




}
