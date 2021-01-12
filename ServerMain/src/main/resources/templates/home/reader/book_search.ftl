<#import "../../common/layout.ftl" as layout />
<@layout.layout title="标题">
    <!-- Begin Page code -->
    <!-- Build your select: -->
    <script type="text/javascript" src="js/bootstrap-multiselect.js"></script>
    <link rel="stylesheet" href="css/bootstrap-multiselect.css" type="text/css"/>
    <select id="example-getting-started" multiple="multiple">
        <option value="filter_title">filter_title</option>
        <option value="filter_publisher">filter_publisher</option>
        <option value="filter_description">filter_description</option>
        <option value="filter_available">filter_available</option>
        <option value="filter_type">filter_type</option>
        <option value="filter_author">filter_author</option>
        <option value="page">page</option>
    </select>
    <!-- Initialize the plugin: -->
    <script type="text/javascript">
        $(document).ready(function() {
            $('#example-getting-started').multiselect();
        });
    </script>



    <!-- End of page code -->
</@layout.layout>