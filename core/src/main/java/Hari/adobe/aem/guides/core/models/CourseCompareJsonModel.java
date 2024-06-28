//package Hari.adobe.aem.guides.core.models;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.annotation.PostConstruct;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.api.resource.Resource;
//import org.apache.sling.api.resource.ResourceResolver;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Exporter;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.OSGiService;
//import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
//import org.apache.sling.models.annotations.injectorspecific.Self;
//import org.apache.sling.models.annotations.injectorspecific.SlingObject;
//import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.day.cq.commons.Externalizer;
//import com.day.cq.wcm.api.Page;
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import com.fasterxml.jackson.annotation.JsonRawValue;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Model(adaptables = { SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//@Exporter(name = "jackson", selector = "compare", extensions = "json")
//@JsonPropertyOrder({ "name", "id", "version", "tinyid", "category", "tags", "link", "apply", "campuses", "study-commitment", "custom", "hbookLink" })
//public class CourseCompareJsonModel {
//
//    private static final Logger LOG = LoggerFactory.getLogger(CourseCompareJsonModel.class);
//
//    @Self
//    private SlingHttpServletRequest request;
//
//    @ScriptVariable
//    private Page currentPage;
//
//    @SlingObject
//    private ResourceResolver resourceResolver;
//
//    @SlingObject
//    private Resource resource;
//
//    @ValueMapValue(name = "jcr:title")
//    private String name;
//
//    @ValueMapValue
//    private String specialisationName;
//
//    @ValueMapValue
//    @JsonProperty("tinyid")
//    private String tinyId;
//
//    @ValueMapValue
//    private String category;
//
//    @ValueMapValue
//    @JsonProperty("apply")
//    private String applyLink;
//
//    // Assuming CourseRecordEntityPageData and CustomAttributeItem are valid classes
//    @JsonIgnore
//    private CourseRecordEntityPageData courseRecord;
//
//    private CustomAttributeItem campuses;
//
//    @JsonProperty("study-commitment")
//    private CustomAttributeItem studyModel;
//
//    private Map<String, Object> custom = new HashMap<>();
//
//    private String id;
//
//    private String version;
//
//    private String hbookLink;
//
//    private String link;
//
//    private String tags;
//
//    @OSGiService
//    private Externalizer externalizer;
//
//    @JsonIgnore
//    private String compareJson;
//
//    @JsonProperty("delivery-mode")
//    private String[] deliveryMode;
//
//    @PostConstruct
//    protected void init() {
//        if (courseRecord != null && courseRecord.getCourse() != null) {
//            id = courseRecord.getCourse().getCourseCode();
//            version = courseRecord.getCourse().getCourseVersion();
//            hbookLink = courseRecord.getCourse().getHbookLink();
//            setTags(getTagObject(resource));
//            setCampusAndStudyJsonObjects(courseRecord);
//            setLink(currentPage.getPath() + ".html");
//            if (StringUtils.isNotBlank(applyLink)) {
//                setApplyLink(externalizer.absoluteLink(request, "https", resourceResolver.map(LinkUtils.formatLinkUrl(applyLink))));
//            }
//            custom = getCustomObject(courseRecord);
//        }
//
//        ObjectMapper compareMapper = new ObjectMapper();
//        compareMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        try {
//            setCompareJson(compareMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
//        } catch (JsonProcessingException e) {
//            LOG.error("JSON Processing Exception {}", e);
//        }
//    }
//
//    public CourseRecordEntityPageData getCourseRecord() {
//        return courseRecord;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getVersion() {
//        return version;
//    }
//
//    public String getHbookLink() {
//        return hbookLink;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public CustomAttributeItem getCampuses() {
//        return campuses;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getCustom() {
//        return custom.isEmpty() ? null : custom;
//    }
//
//    @JsonRawValue
//    public String getCategory() {
//        JSONObject categoryJson = new JSONObject();
//        try {
//            categoryJson.put("type", "class");
//            categoryJson.put("content", category);
//        } catch (JSONException e) {
//            LOG.error("JSON Exception {}", e);
//        }
//        return categoryJson.toString();
//    }
//
//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link.replaceFirst("/content/digital", "");
//    }
//
//    public String getApplyLink() {
//        return applyLink;
//    }
//
//    public void setApplyLink(String applyLink) {
//        this.applyLink = applyLink;
//    }
//
//    @JsonRawValue
//    public String getTags() {
//        return tags;
//    }
//
//    public void setTags(String tags) {
//        this.tags = tags;
//    }
//
//    public String[] getDeliveryMode() {
//        return deliveryMode;
//    }
//
//    public String getCompareJson() {
//        return compareJson;
//    }
//
//    public void setCompareJson(String compareJson) {
//        this.compareJson = compareJson;
//    }
//
//    private Map<String, Object> getCustomObject(CourseRecordEntityPageData courseRecord) {
//        Map<String, Object> customMap = new HashMap<>();
//        if (courseRecord.getCustom() != null && courseRecord.getCustom().getCustomAttributeModelList() != null) {
//            courseRecord.getCustom().getCustomAttributeModelList().forEach(customAttributeModel -> {
//                if (customAttributeModel.getCustomAttributeItemList() != null) {
//                    customAttributeModel.getCustomAttributeItemList().forEach(customAttributeItem -> {
//                        if (specialisationName.equals(customAttributeItem.getSpecialisationName())) {
//                            if ("text".equals(customAttributeItem.getType())) {
//                                customMap.put(customAttributeModel.getDataElementName(), new CustomAttributeItem()
//                                        .new ItemBase(customAttributeItem.getType(), customAttributeItem.getContent()));
//                            } else {
//                                customMap.put(customAttributeModel.getDataElementName(), customAttributeItem);
//                            }
//                        }
//                    });
//                }
//            });
//        }
//        return customMap;
//    }
//
//    private void setCampusAndStudyJsonObjects(CourseRecordEntityPageData courseRecord) {
//        JSONObject campusContent = new JSONObject();
//        JSONArray studyModeContent = new JSONArray();
//        if (courseRecord.getCourse().getSpecialisations() != null) {
//            courseRecord.getCourse().getSpecialisations().forEach(courseSpecialisation -> {
//                if (specialisationName.equals(courseSpecialisation.getSpecialisationName())) {
//                    deliveryMode = courseSpecialisation.getDeliveryMode();
//                    courseSpecialisation.getCampusList().forEach(campuse -> {
//                        try {
//                            campusContent.put(campuse.getCampus(), campuse.getAtarCode());
//                        } catch (JSONException e) {
//                            LOG.error("JSON Exception {}", e);
//                        }
//                    });
//
//                    if (courseSpecialisation.getStudyItem() != null) {
//                        courseSpecialisation.getStudyItem().forEach(studyItem -> {
//                            studyModeContent.put(studyItem.getStudyLength() + " years " + studyItem.getStudyMode().toLowerCase());
//                        });
//                    }
//                }
//            });
//        }
//        if (campusContent.length() > 0) {
//            campuses = new CustomAttributeItem();
//            campuses.setContent(campusContent.toString());
//            campuses.setType("table");
//        }
//        if (studyModeContent.length() > 0) {
//            studyModel = new CustomAttributeItem();
//            studyModel.setContent(studyModeContent.toString());
//            studyModel.setType("list");
//        }
//    }
//
//    private String getTagObject(Resource resource) {
//        JSONObject tagObject = new JSONObject();
//        ReferredContentPage contentPage = resource.adaptTo(ReferredContentPage.class);
//        if (contentPage != null) {
//            List<String> labelList = new ArrayList<>();
//            String primaryLabel = contentPage.getPrimaryLabel();
//            String secondaryLabel = contentPage.getSecondaryLabel();
//            if (StringUtils.isNotBlank(primaryLabel)) {
//                labelList.add(primaryLabel);
//            }
//            if (StringUtils.isNotBlank(secondaryLabel)) {
//                labelList.add(secondaryLabel
