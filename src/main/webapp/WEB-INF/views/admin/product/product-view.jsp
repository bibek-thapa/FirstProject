<%@include file="../../header.jsp" %>
<%@include file="../../navbar.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="thumbnail">
                <img src="${SITE_URL}/imageDisplay?id=${product.id}" alt="" class="img-responsive">
            </div>
        </div>
        <div class="col-md-6">
            <div class="row">
                <div class="col-md-12">
                    <h1>${product.productName}</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <span class="label label-primary">Vintage</span>
                    <span class="monospaced">${product.productCode}</span>
                </div>
            </div><!-- end row -->

            <div class="row">
                <div class="col-md-12">
                    <p></p>
                    <p class="description">

                        Mouse which has great quality
                    </p>
                </div>
            </div><!-- end row -->

            <div class="row">
                <div class="col-md-3">
                    <span class="sr-only">Four out of 5 stars</span>
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                    <div class="col-md-1">
                        <span class="label label-success">61</span> </div>

                    <div class="col-md-6">
                        <span class="monospaced">Write a review</span>
                    </div>
                </div>
            </div> <!-- end row -->

            <div class="row">
                <div class="col-md-12">
                    <h2 class="product-price">Rs.&nbsp;${product.pperUnit}</h2>
                </div>
            </div><!-- end row -->
            <form method="post" action="${SITE_URL}/cart/add/${product.id}">
                <div class="row add-to-cart">
                    <div class="col-md-5 product-qty">
                        <span class="btn btn-default btn-lg btn-qty">
                            <span class="glyphicon glyphicon-plus aria-hidden"></span>
                        </span>

                        <input class="btn btn-default btn-lg btn-qty" value="1" name="orderQuantity"/>

                        <span class="btn btn-default btn-lg btn-qty aria-hidden">
                            <span class="glyphicon glyphicon-minus"></span>
                        </span>

                    </div>

                    <div class="col-md-4">
                        <button class="btn btn-lg" type="submit">
                            Add to Cart 
                        </button>
                    </div>
                </div><!--end row -->
                <p></p>
            </form>    


            <div class="row">
                <div class="col-md-4 text-center">
                    <span class="monospaced">In Stock(10)</span>
                </div>
                <span></span>

                <div class="col-md-4 col-md-offset-1">
                    <a class="monospaced" href="#">Add to shopping List</a>
                </div>
            </div><!--end row -->

            <hr>


            <div class="row">
                <div class="col-md-12 top-10">
                    <p>To order by telephone, <a href="tel:18005551212">please call 1-800-555-1212</a></p>
                </div>
            </div><!-- end row -->

            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active">
                    <a href="#description"
                       aria-controls="description"
                       role="tab"
                       data-toggle="tab"
                       >Description</a>
                </li>
                <li role="presentation">
                    <a href="#features"
                       aria-controls="features"
                       role="tab"
                       data-toggle="tab"
                       >Features</a>
                </li>
                <li role="presentation">
                    <a href="#notes"
                       aria-controls="notes"
                       role="tab"
                       data-toggle="tab"
                       >Notes</a>
                </li>
                <li role="presentation">
                    <a href="#reviews"
                       aria-controls="reviews"
                       role="tab"
                       data-toggle="tab"
                       >Reviews</a>
                </li>
            </ul>


            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="description">
                    <p></p>
                    <p>
                        The 'Brownie' Flash B is a box camera taking 2&frac14; × 3&frac14;" frames on 620 film, made of sheet metal by Kodak Ltd. in England, 1958-60. 
                    </p>
                </div>
                <div role="tabpanel" class="tab-pane" id="features">
                    <p></p>
                    <p>Hello I am features</p>
                </div>
                <div role="tabpanel" class="tab-pane" id="notes"></div>
                <div role="tabpanel" class="tab-pane" id="reviews"></div>
            </div>




        </div>
    </div>    
</div>




<%@include file="../../footer.jsp" %>