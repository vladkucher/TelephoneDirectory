var ajaxUrl = 'ajax/phonebook/';
var datatableApi;

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

$(function () {
    datatableApi = $('#datatable').DataTable(extendsOpts({
        "columns": [
            {
                "data": "name"
            },
            {
                "data": "surname"
            },
            {
                "data": "mobilePhone"
            },
            {
                "data": "homePhone"
            },
            {
                "render": renderEditBtn,
                "defaultContent": "",
                "orderable": false
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ]
    }));
});

var form;
function makeEditable() {
    form = $('#detailsForm');
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize(),
        success: function () {
            updateTable();
            form.find(":input").val("");
        }
    });
}

function updateRow(id) {
    $.get(ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
    });
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
        }
    });
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

// https://api.jquery.com/jquery.extend/#jQuery-extend-deep-target-object1-objectN
function extendsOpts(opts) {
    $.extend(true, opts,
        {
            "ajax": {
                "url": ajaxUrl,
                "dataSrc": ""
            },
            "paging": false,
            "info": true,
            "initComplete": makeEditable
        }
    );
    return opts;
}

function renderEditBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(' + row.id + ');">' +
            '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>';
    }
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(' + row.id + ');">'+
            '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>';
    }
}