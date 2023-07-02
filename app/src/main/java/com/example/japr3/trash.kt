data class Commit(
    val tree: Tree,
    val previousCommit: Commit?
)

interface SnapshotPart

data class Tree(
    val tree: Map<String, SnapshotPart>
) : SnapshotPart

data class Blob(
    val content: List<Byte>
) : SnapshotPart


fun main() {

    val tree = Tree(mapOf(
        "text.txt" to Blob(listOf())
    ))

    val repository1 = Commit(tree, null)

    val tree2 = Tree(mapOf(
        "text.txt" to Blob("Привет, мир".toByteArray(Charsets.UTF_8).asList()),
        "advanced_git.txt" to Blob("Привет, второй коммит".toByteArray(Charsets.UTF_8).asList())
    ))

    val repository = Commit(tree2, repository1)

    println(repository)
    //println("test")
}