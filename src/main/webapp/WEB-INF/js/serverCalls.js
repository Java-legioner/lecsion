
$("button.createProduct").click(function() {

        let name = $("form.createProduct input.productName").val();
    let description = $("form.createProduct input.productDescription").val();
    let price = $("form.createProduct input.productPrice").val();

    let productForm = {
        name : name,
        description : description,
        price : price
    };
    $.post("product", productForm, function(data) {
        if(data == 'success'){
            alert('success');
        }
    });

});



$("button.buy-product").click(function() {
    var productId = jQuery(this).attr("product-id");


    $.post("bucket", {'productId':productId},
        function(data) {
            if (data == 'Success') {
                $("[data-dismiss=modal]").trigger({type: "click"});

            }
        });
});


