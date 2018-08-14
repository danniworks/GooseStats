package server.controller;

import ui.builder.ProfileBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The purpose of this class is to handle all object related stuff
 */
public class ObjectController {

    private String[] urls; // The first item of urls is always the api key params
    private Stack<String> ret = new Stack<>();
    private Map<String, Object> map = new HashMap<String, Object>();

    public ObjectController(){}

    /**
     * Builds html according to filter
     * @param filter
     */
    public void getHtml(String filter) throws IOException {
        if(filter.equals("profile")) {
            ProfileBuilder pb = new ProfileBuilder(urls);
            ret.push(pb.getRankedContainer()); //Ranked Stats container content
            ret.push(pb.getHtml()); //Sidebar content
        }
    }

    /**
     * Set urls to be requested; The first item in array is the api key
     * @param urls
     */
    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    /**
     * Get the intended data from UI builders
     * @return String of expected data
     */
    public String getRet() {
        return ret.pop();
    }
}
