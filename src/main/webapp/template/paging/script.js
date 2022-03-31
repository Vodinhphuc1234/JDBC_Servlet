
startPage=$('#receivedPage').val()
totalPage=$('#receivedTotal').val()
$('#pagination-demo').twbsPagination({
    totalPages: parseInt(totalPage),
    startPage: parseInt(startPage),
    visiblePages: 6,
    next: 'Next',
    prev: 'Prev',
    onPageClick: function (event, page) {
        //fetch content and render here
        $('#page-content').text('Page ' + page) + ' content here';

        $('#page').val(page)
        $('#perPage').val($('#setPerPage').val())

        if (page != $('#receivedPage').val())
            $('#paginationForm').submit()
    }
});
