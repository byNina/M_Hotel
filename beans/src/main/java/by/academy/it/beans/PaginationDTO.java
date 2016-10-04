package by.academy.it.beans;

/**
 * Created by User on 03.10.2016.
 */
public class PaginationDTO {
    int id;
    int pages;
    int pagesize;

    public PaginationDTO() {
        this.pagesize=5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
}
