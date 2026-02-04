package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateWorkflowParams {

    private String slug;
    private String name;
    private List<Map<String, Object>> steps;

    public CreateWorkflowParams() {}

    public String getSlug() { return slug; }
    public CreateWorkflowParams setSlug(String slug) { this.slug = slug; return this; }

    public String getName() { return name; }
    public CreateWorkflowParams setName(String name) { this.name = name; return this; }

    public List<Map<String, Object>> getSteps() { return steps; }
    public CreateWorkflowParams setSteps(List<Map<String, Object>> steps) { this.steps = steps; return this; }
}
