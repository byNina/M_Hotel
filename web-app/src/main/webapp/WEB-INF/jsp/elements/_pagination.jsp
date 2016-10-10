<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


Всего заявок:${totalcount}ǀ
<c:if test="${page>1}">
    <a href="showRequests?page=${page-1}"> ⏪</a>
</c:if>
<c:if test="${page>2}">
    <a href="showRequests?page=${page-2}">${page-2}</a>
</c:if>
<c:if test="${page>1}">
    <a href="showRequests?page=${page-1}">${page-1}</a>
</c:if>
<a class="active" href="showRequests?page=${page}">${page}</a>
<c:if test="${page<(pagination.pages)}">
    <a href="showRequests?page=${page+1}">${page+1}</a>
</c:if>
<c:if test="${(page+1)<(pagination.pages)}">
    <a href="showRequests?page=${page+2}">${page+2}</a>
</c:if>
<c:if test="${(page+2)<(pagination.pages)}">
    <span>...${pagination.pages}</span>
</c:if>
<c:if test="${page<(pagination.pages)}">
    <a href="showRequests?page=${page+1}"> ⏩</a>
</c:if>
<span style="padding: 0px 10px;">&nbsp;</span>
Показывать по
<a href="pagination?pagesize=3">3</a>
<a href="pagination?pagesize=5">5</a>
<a href="pagination?pagesize=10">10</a>
</hr>