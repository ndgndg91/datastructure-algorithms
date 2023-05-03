package datastructure.algorithms.algorithms.coursea.dynamicconnectivity;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class UF {
    private final int objCount;
    private final List<List<Integer>> components;

    public UF(int objCount) {
        this.objCount = objCount;
        this.components = new ArrayList<>();
        for (int i = 0; i < objCount; i++) {
            List<Integer> connection = new ArrayList<>();
            connection.add(i);
            this.components.add(connection);
        }
    }

    public void union(int p, int q) {
        List<Integer> pComponent = new ArrayList<>();
        List<Integer> qComponent = new ArrayList<>();
        List<Integer> newComponent = new ArrayList<>();
        for (List<Integer> component : components) {
            if (component.contains(p)) {
                pComponent = component;
            }

            if (component.contains(q)) {
                qComponent = component;
            }
        }

        if (pComponent != qComponent) {
            newComponent.addAll(pComponent);
            newComponent.addAll(qComponent);
            components.remove(pComponent);
            components.remove(qComponent);
            components.add(newComponent);
        }
    }

    public boolean connected(int p, int q) {
        List<Integer> pComponent = new ArrayList<>();
        List<Integer> qComponent = new ArrayList<>();
        for (List<Integer> component : components) {
            if (component.contains(p)) pComponent = component;
            if (component.contains(q)) qComponent = component;
        }

        return pComponent == qComponent;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UF.class.getSimpleName() + "[", "]")
                .add("objCount=" + objCount)
                .add("components=" + components)
                .toString();
    }
}
