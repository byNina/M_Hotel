<c:if test="${sessionScope.locale == 'locale_ru_RU' or empty sessionScope.locale}" >
    <fmt:setBundle basename="locale_ru_RU" />
</c:if>
<c:if test="${sessionScope.locale == 'locale_en_US'}">
    <fmt:setBundle basename="locale_en_US" />
</c:if>