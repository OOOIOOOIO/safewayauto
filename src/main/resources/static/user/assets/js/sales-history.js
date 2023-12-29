    function clickPage(page){

    $.ajax({
        type: "GET",
        url: "/carlist?page="+page,
        // dataType: "json",
        success: function (carList) {

            makePagenation(carList);
            console.log(carList);

            $("#carListUl").replaceWith(carList); // carList 조정

        },
        error: function () {
            alert("error");
        }
    })
}


    function makePagenation(carList){
    let pagination = $("#pagination");
    pagination.empty();

    let curr = carList.number; // 0 부터임

    console.log("curr : " +curr);
    let endPage = Math.ceil((curr+1) / 10.0) * 10; // 1~10
    let startPage = endPage - 9; // 1~10

    if(endPage > carList.totalPages-1){ // totalPage는 1부터 셈(Page는 0부터 시작이니 1 빼기)
    endPage = carList.totalPages;
}

    if(curr > 0){ // 이전버튼(<<)
    pagination.append(`<a onclick="clickPage(${curr-1}); return false;" href="javascript:void(0)" >&laquo;</a>`)
}

    for(let i = startPage; i <= endPage; i++){
    pagination.append(`<a onclick="clickPage(${i-1}); return false;" href="javascript:void(0)">${i}</a>`)
}

    if(curr + 1 < carList.totalPages){
    pagination.append(`<a onclick="clickPage(${curr+1}); return false;" href="javascript:void(0)">&raquo;</a>`)
}

}

    // 처음 들어올 때
    $(document).ready(function (){
        co
    clickPage(0);
})
