package entity;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class Item {
    private String itemId;
    private String name;
    private String address;
    private Set<String> keywords;
    private String imageUrl;
    private String url;

    private Item(ItemBuilder builder) {
        itemId = builder.itemId;
        name = builder.name;
        address = builder.address;
        imageUrl = builder.imageUrl;
        url = builder.url;
        keywords = builder.keywords;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        obj.put("item_id", itemId).put("name", name).put("address", address)
            .put("keywords", new JSONArray(keywords)).put("image_url", imageUrl).put("url", url);
        return obj;
    }

    public static class ItemBuilder {
        private String itemId;
        private String name;
        private String address;
        private Set<String> keywords;
        private String imageUrl;
        private String url;

        public ItemBuilder setItemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        public ItemBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ItemBuilder setKeywords(Set<String> keywords) {
            this.keywords = keywords;
            return this;
        }

        public ItemBuilder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public ItemBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
