package structurePattern

/**
 * 组合模式，也成为部分整体模式，属于结构性设计模式。
 *
 * 思想：将一组相似的对象看做一个对象来处理，并根据一个树状结构来组合关联对象；提供统一的方法来访问相关的对象，
 * 以此忽略掉对象与对象集合之间的差别。
 */
fun main() {
    val headCompany = HeadCompany()
    headCompany.recruit()
    headCompany.raiseSalary()
}

interface CompanyComponent {
    fun recruit()
    fun raiseSalary()
}

class HeadCompany : CompanyComponent {
    private val subCompanyComponent = SubCompanyComponent()
    private val managementOffice = ManagementOffice()

    override fun recruit() {
        println("总公司招人了")
        subCompanyComponent.recruit()
        managementOffice.recruit()
        println("总公司找人结束")
    }

    override fun raiseSalary() {
        println("总公司涨薪了")
        subCompanyComponent.raiseSalary()
        managementOffice.raiseSalary()
        println("总公司涨薪结束")
    }
}

class SubCompanyComponent : CompanyComponent {
    override fun recruit() {
        println("子公司招人了")
    }

    override fun raiseSalary() {
        println("子公司涨薪了")
    }
}

class ManagementOffice : CompanyComponent {
    override fun recruit() {
        println("管理办公室招人了")
    }

    override fun raiseSalary() {
        println("管理办公室涨薪了")
    }
}