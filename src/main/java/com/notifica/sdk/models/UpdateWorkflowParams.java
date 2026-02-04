package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateWorkflowParams {

    private String name;
    private List<Map<String, Object>> steps;

    public UpdateWorkflowParams() {}

    public String getName() { return name; }
    public UpdateWorkflowParams setName(String name) { this.name = name; return this; }

    public List<Map<String, Object>> getSteps() { return steps; }
    public UpdateWorkflowParams setSteps(List<Map<String, Object>> steps) { this.steps = steps; return this; }
}
