package com.ndnu.alumni.model;

public class Job
{
    private String id;
    private String title;
    private String type;
    private String company;
    private String description;

    public Job(String id, String title, String type, String company, String description)
    {
        setId(id);
        setTitle(title);
        setType(type);
        setCompany(company);
        setDescription(description);
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    // Getters
    public String getId()
    {
        return this.id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getType()
    {
        return this.type;
    }

    public String getCompany()
    {
        return this.company;
    }

    public String getDescription()
    {
        return this.description;
    }
}
