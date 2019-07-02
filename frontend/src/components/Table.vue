<template>
    <div>
        <el-table :data="tableData.filter(data=>!search
                            || (searchItem==='bookName'?data.bookName.includes(search):
                                        (searchItem==='userName'?data.userName.includes(search):
                                                    data.orderID.includes(search))))"
                  stripe
                  style="width: 100%">
          <el-button type="info" @click="modifyUser(scope.row.phone)">修改</el-button>
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
                <el-table-column label= '数量' prop= 'amount' sortable>
                    <template slot-scope="scope">
                        <a type="info">-</a>
                        <el-input :value=scope.row.amount></el-input>
                        <a type="info">+</a>
                    </template>
                </el-table-column>

                <el-table-column align="right" width="90">
                    <template slot="header" slot-scope="scope">
                        <el-input :placeholder="placeholder" prefix-icon="el-icon-search"
                                  style="width: 300px" v-model="search"></el-input>
                    </template>
                    <template slot-scope="scope">
                        <el-button type="info" @click.native.prevent="deleteRow(scope.$index, tableData)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
export default {
  name: 'Table',
  data () {
    return {
      search: ''
    }
  },
  props: {
    placeholder: String,
    searchItem: String,
    tableColumn: Array,
    tableData: Array
  },
  methods: {
    deleteRow (index, rows) {
      rows.splice(index, 1)
    },
    modifyUser (val) {
    },
    checkDetail (val) {
    }
  }
}
</script>

<style>
    @import url("../users/style.css");

</style>
