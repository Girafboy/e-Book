<template>
    <div>
        <el-input :placeholder="placeholder" prefix-icon="el-icon-search"
                  style="width: 300px" v-model="search"></el-input>
        <el-table :data="tableData.filter(data=>!search
                            || (searchItem==='bookName'?data.bookName.includes(search):
                                        (searchItem==='userName'?data.userName.includes(search):
                                                    data.orderID.includes(search))))"
                  stripe
                  style="width: 100%">
            <el-table-column>
                <el-table-column
                        type="index"
                ></el-table-column>
                <el-table-column
                        v-for="column in tableColumn"
                        :label= column.label
                        :prop= column.prop
                        :key="column.id"
                        sortable
                ></el-table-column>
                <el-table-column label="操作" align="center" width="90">
                    <template slot-scope="scope">
                        <el-button type="info" @click="modifyUser(scope.row.phone)">修改</el-button>
                        <br>
                        <el-button type="info" @click="deleteUser(scope.row.phone)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    export default {
        name: "Table",
        data () {
            return {
                search: '',
            }
        },
        props:{
            placeholder:String,
            searchItem:String,
            tableColumn:Array,
            tableData:Array
        },
        methods:{
            deleteUser(val){
            },
            modifyUser(val){
            },
            checkDetail(val){
            }
        }
    }
</script>

<style>
    @import url("../users/style.css");

</style>
