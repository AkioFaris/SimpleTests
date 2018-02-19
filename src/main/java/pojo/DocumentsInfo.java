
package pojo;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class DocumentsInfo {

    @SerializedName("addedDocumentCount")
    @Expose
    public Integer addedDocumentCount;
    @SerializedName("deletedDocumentCount")
    @Expose
    public Integer deletedDocumentCount;
    @SerializedName("documentFiles")
    @Expose
    public List<String> documentFiles = new ArrayList<String>();
    @SerializedName("taxonomyFiles")
    @Expose
    public List<String> taxonomyFiles = new ArrayList<String>();

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("addedDocumentCount", addedDocumentCount).append("deletedDocumentCount", deletedDocumentCount).append("documentFiles", documentFiles).append("taxonomyFiles", taxonomyFiles).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(documentFiles).append(deletedDocumentCount).append(taxonomyFiles).append(addedDocumentCount).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DocumentsInfo) == false) {
            return false;
        }
        DocumentsInfo rhs = ((DocumentsInfo) other);
        return new EqualsBuilder().append(documentFiles, rhs.documentFiles).append(deletedDocumentCount, rhs.deletedDocumentCount).append(taxonomyFiles, rhs.taxonomyFiles).append(addedDocumentCount, rhs.addedDocumentCount).isEquals();
    }

}
