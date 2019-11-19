package scenenavigator.mvc.controllers;

import scenenavigator.mvc.models.SceneOneModel;

public class SceneOneController {

    private SceneOneModel model;

    public SceneOneController(SceneOneModel model) {
        this.model = model;
    }

    public void incrementNumber() {
        model.setNumber(model.getNumber() + 1);
    }
}
