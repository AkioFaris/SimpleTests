package jdiTestSite.enums;

public enum ContFormElem {
	/* Labels with "_LOG" correspond only with log records, labels with "_RES" correspond only with result records
	 * Labels without "_LOG" or "_RES" correspond with both log and result records */
	NAME("Name"),
    LASTNAME_LOG("LastName"),
    LASTNAME_RES("Last Name"),
    DESCRIPT("Description"),
    SUMMARY("Summary"),
    SUBMIT_LOG("submit");

    final public String tag;

    ContFormElem(String tag) {
        this.tag = tag;
    }
}
