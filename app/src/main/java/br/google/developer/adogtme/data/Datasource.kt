package br.google.developer.adogtme.data

import androidx.lifecycle.MutableLiveData
import br.google.developer.adogtme.R
import br.google.developer.adogtme.models.*

class Datasource {

    fun loadAccounts(): List<Account>{
        return listOf(Account("_",
        "_",
        SexType.Male,
        "_",
        "_",
        R.drawable.men,
        false))
    }

    fun loadPets(): List<Pet>{
        return listOf(
            Pet("Curitiba - PR",
                PetTypeType.Rabbit,
                "celeste",
                "",
                10,
                "O Celeste é um coelho brincalhão e ama comer",
                "O Celeste é um coelho! Ama brincar",
                R.drawable.celeste,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,3),
                    PetAttribute(PetAttributeKeyType.Friendliness,5),
                    PetAttribute(PetAttributeKeyType.Playfulness,9),
                    PetAttribute(PetAttributeKeyType.Watchfulness,4)),
                OwnerPet("Letícia Ferreira", R.drawable.leticia),
                MutableLiveData(true),
            ),
            Pet("Curitiba - PR",
                PetTypeType.Panda,
                "Thor",
                "",
                10,
                "O Thor é um panda brincalhão e ama comer",
                "O Thor é um panda! Ama brincar",
                R.drawable.thor,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,3),
                    PetAttribute(PetAttributeKeyType.Friendliness,5),
                    PetAttribute(PetAttributeKeyType.Playfulness,9),
                    PetAttribute(PetAttributeKeyType.Watchfulness,4)),
                OwnerPet("Letícia Ferreira", R.drawable.leticia),
                MutableLiveData(true),
            ),
            Pet("Curitiba - PR",
                PetTypeType.Cat,
                "Chuvisco",
                "",
                10,
                "O Chuvisco é um gato muito carinhoso e dorminhoco, sempre gosta de ficar deitado e assistindo tv",
                "O Chuvisco é um gato muito carinhoso e dorminhoco",
                R.drawable.chuvisco,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,3),
                    PetAttribute(PetAttributeKeyType.Friendliness,5),
                    PetAttribute(PetAttributeKeyType.Playfulness,9),
                    PetAttribute(PetAttributeKeyType.Watchfulness,4)),
                OwnerPet("Letícia Ferreira", R.drawable.leticia),
                MutableLiveData(true),
            ),
            Pet("Curitiba - PR",
                PetTypeType.Cat,
                "Cléo",
                "",
                10,
                "A Cléo é uma gata muito charmosa, esperta e carinhosa *-*\n",
                "Cléo é uma gata muito carinhosa",
                R.drawable.cleo,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,3),
                    PetAttribute(PetAttributeKeyType.Friendliness,5),
                    PetAttribute(PetAttributeKeyType.Playfulness,9),
                    PetAttribute(PetAttributeKeyType.Watchfulness,4)),
                OwnerPet("Letícia Ferreira", R.drawable.leticia),
                MutableLiveData(true),
            ),
            Pet("Curitiba - PR",
                PetTypeType.Cat,
                "Garfield",
                "",
                10,
                "Um gato de cor caramelo listrado. Preguiçoso, guloso, viciado em café, amante de televisão e acima de tudo, sarcástico. Adora chutar Odie da mesa, arrotar, caçar pássaros e carteiros, o seu prato favorito é lasanha.\n",
                "Garfield é gato muito comilão e amigável",
                R.drawable.garfield,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,3),
                    PetAttribute(PetAttributeKeyType.Friendliness,5),
                    PetAttribute(PetAttributeKeyType.Playfulness,9),
                    PetAttribute(PetAttributeKeyType.Watchfulness,4)),
                OwnerPet("Letícia Ferreira", R.drawable.leticia),
                MutableLiveData(true),
        ),
            Pet("Curitiba - PR",
                PetTypeType.Cat,
                "Yuri",
                "",
                10,
                "Este é o Yuri\n" +
                        "Este garoto é filho de uma gata que tirei da rua, que ficava solta perto de casa.\n" +
                        "Ele tem 10 meses de idade apenas, come ração e usa a caixa de areia normalmente.\n" +
                        "Não é castrado e não tomou nenhuma vacina, mas passei remédio de pulgas nele..\n" +
                        "Foi criado somente dentro de casa até hoje, é muito ativo adora subir nas coisas, escalar a cortina e principalmente brincar de luta com os irmãos dele, é um lutador por natureza... kkkkkk",
                "Baruk é um cachorro amigavél e sociável",
                R.drawable.yuri,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,3),
                    PetAttribute(PetAttributeKeyType.Friendliness,5),
                    PetAttribute(PetAttributeKeyType.Playfulness,9),
                    PetAttribute(PetAttributeKeyType.Watchfulness,4)),
                OwnerPet("Lucas Motta", R.drawable.lucas),
                MutableLiveData(true),
            ),

            Pet("Curitiba - PR",
                PetTypeType.Dog,
                "Baruk",
                "",
                10,
                "Baruk é um filhotão de 7 meses de idade, está vermifugado. Foi abandonado juntamente com seus irmãos em uma caixa de papelão quando tinha 2 meses. Procuramos uma família responsável e amorosa pra ele, para que nunca mais expetimente o abandono e a rejeição.",
                "Baruk é um cachorro amigavél e sociável",
                R.drawable.pet_001,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,3),
                    PetAttribute(PetAttributeKeyType.Friendliness,5),
                    PetAttribute(PetAttributeKeyType.Playfulness,9),
                    PetAttribute(PetAttributeKeyType.Watchfulness,4)),
                OwnerPet("Lucas Motta", R.drawable.lucas),
                MutableLiveData(true),
            ),

            Pet("Florianopolis - SC",
                PetTypeType.Dog,
                "Elliot",
                "",
                10,
                "Elliot vivia nas ruas, sempre no mesmo lugarzinho, onde era alimentado por algumas pessoas.\n Um dia, uma caçamba de entulho esmagou sua patinha.\n ELLIOT rolou de dor, vomitando e fugiu.\n Quando reapareceu alguns dias depois, os bichos tinham comido a região.\n Seus cuidadores deram remédio, porém ele precisava de atendimento.",
                "Elliot é dócil e cuidadoso",
                R.drawable.pet_002,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,4),
                    PetAttribute(PetAttributeKeyType.Friendliness,2),
                    PetAttribute(PetAttributeKeyType.Playfulness,7),
                    PetAttribute(PetAttributeKeyType.Watchfulness,5)),
                OwnerPet("Lucas Motta", R.drawable.lucas),
                MutableLiveData(true)),
            Pet("Maringa - PR",
                PetTypeType.Dog,
                "Luna",
                "",
                10,
                "Luna vivia nas ruas, sempre no mesmo lugarzinho, onde era alimentado por algumas pessoas.\n Um dia, uma caçamba de entulho esmagou sua patinha.\n ELLIOT rolou de dor, vomitando e fugiu.\n Quando reapareceu alguns dias depois, os bichos tinham comido a região.\n Seus cuidadores deram remédio, porém ele precisava de atendimento.",
                "Luna amigável e brincalhona",
                R.drawable.pet_003,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,4),
                    PetAttribute(PetAttributeKeyType.Friendliness,2),
                    PetAttribute(PetAttributeKeyType.Playfulness,7),
                    PetAttribute(PetAttributeKeyType.Watchfulness,5)),
                OwnerPet("Lucas Motta", R.drawable.lucas),
                MutableLiveData(true),),
            Pet("Florianopolis - SC",
                PetTypeType.Dog,
                "Tiberio",
                "",
                10,
                "Estou prontinho para encher um lar de muito amor. Sou esse pretiiiiin perfeito das fotos: MUITO carinhoso e tranquilo, companheiro e amoroso. Já estou acostumado em viver em apto e o que eu mais AUmo fazer é dormir hihiiiii sou um bichinho preguiça. Prometo lambeijos para a vida toda e ser o melhor amigo do \uD83C\uDF0E!",
                "Tiberio é puro amor!",
                R.drawable.pet_004,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,4),
                    PetAttribute(PetAttributeKeyType.Friendliness,2),
                    PetAttribute(PetAttributeKeyType.Playfulness,7),
                    PetAttribute(PetAttributeKeyType.Watchfulness,5)),
                OwnerPet("Lucas Motta", R.drawable.lucas),
                MutableLiveData(true),),
            Pet("São Paulo - SP",
                PetTypeType.Dog,
                "Levi",
                "",
                10,
                "Oi, eu sou o Levi! \uD83E\uDD20\uD83D\uDC06\n\n Vim aqui contar a minha história para vocês… minha mamãe Filó no mato, próximo a uma fazenda e acabou engravidando de mim, e meus 9 AUirmãos. Depois que nascemos, ficamos todos abandonados nessa fazenda, vivendo em um pasto, até que as tias receberam nosso pedido de ajuda e correram para salvar todos nós! \uD83D\uDE4F\uD83C\uDFFB\n\nChegando no projeto, passamos em consulta e fomos diagnosticados com Parvovirose. Fomos batizados com nomes dos personagens da novela Pantanal \uD83D\uDC06, sou o Levi hehe. Depois, eu e minha AUirmã Marruá fomos morar com @gabiiias e @duduoliveiira_ nossa família temporária. Lá fizemos nosso tratamento e recebemos muito amor, carinho e cuidados \uD83E\uDD70 AUbrigado por tudinho, família temporária!\n\nAgora que estou saudável, estou prontinho para encher um lar de muuuito AUmor. Sou esse pretinho lindo das fotos: muito carinhoso \uD83E\uDD0F\uD83C\uDFFC, companheiro e amoroso. Cheio de charme como mostra as minhas fotinhos com carinha de dó hihi. Prometo lambeijos para a vida toda! Me adota? ♥️",
                "Levi bagunceiro e animado!",
                R.drawable.pet_005,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,4),
                    PetAttribute(PetAttributeKeyType.Friendliness,2),
                    PetAttribute(PetAttributeKeyType.Playfulness,7),
                    PetAttribute(PetAttributeKeyType.Watchfulness,5)),
                OwnerPet("Lucas Motta", R.drawable.lucas),
                MutableLiveData(true),),
            Pet("Rio de Janeiro - RJ",
                PetTypeType.Dog,
                "Bollo",
                "",
                10,
                "Bollo é um Chow Chow de 6 anos de idade e que está em nossa família desde bebê. De comportamento calmo, sempre foi educado para que crescesse de modo saudável física, e psicológicamente. Infelizmente o Bollo teve duas perdas grandes recentemente; seus companheiros ( meus avós ) partiram e o deixaram sob os cuidados da família. Não podemos estar presentes o tempo necessário para que ele tenha o carinho, amor e qualidade de tempo que merece.\nBollo se alimenta com ração super premium e tem uma pelagem bege, linda! Adora comidinhas úmidas e toma banho frequentemente ( 1 vez ao mês ).",
                "Levi bagunceiro e animado!",
                R.drawable.pet_006,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,4),
                    PetAttribute(PetAttributeKeyType.Friendliness,2),
                    PetAttribute(PetAttributeKeyType.Playfulness,7),
                    PetAttribute(PetAttributeKeyType.Watchfulness,5)),
                OwnerPet("Lucas Motta", R.drawable.lucas),
                MutableLiveData(true),),
            Pet("Belo Horizontal - MG",
                PetTypeType.Dog,
                "Yoda",
                "",
                10,
                "Estou prontinho para encher um lar de muito amor. Sou esse pretiiiiin perfeito das fotos: MUITO carinhoso e tranquilo, companheiro e amoroso. Já estou acostumado em viver em apto e o que eu mais AUmo fazer é dormir hihiiiii sou um bichinho preguiça. Prometo lambeijos para a vida toda e ser o melhor amigo do \uD83C",
                "Yoda um cachorro muito bom de praça",
                R.drawable.pet_007,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,4),
                    PetAttribute(PetAttributeKeyType.Friendliness,2),
                    PetAttribute(PetAttributeKeyType.Playfulness,7),
                    PetAttribute(PetAttributeKeyType.Watchfulness,5)),
                OwnerPet("Lucas Motta", R.drawable.lucas),
                MutableLiveData(true),),
            Pet("Belo Horizontal - MG",
                PetTypeType.Dog,
                "Marrua",
                "",
                10,
                "Oi, eu sou a Marruá! \uD83E\uDD20\uD83D\uDC06 Vim aqui contar a minha história para vocês… minha mamãe Filó vivia no mato, próxima a uma fazenda e acabou engravidando de mim, e meus 9 AUirmãos. Depois que nascemos, ficamos todos abandonados nessa fazenda, vivendo em um pasto, até que as tias receberam nosso pedido de ajuda e correram para salvar todos nós! \uD83D\uDE4F\uD83C\uDFFB Chegando no projeto, passamos em consulta e fomos diagnosticados com Parvovirose. Fomos batizados com nomes dos personagens da novela Pantanal \uD83D\uDC06, sou a Marruá hihi. Depois, eu e meu AUirmão Levi fomos morar com @gabiiias e @duduoliveiira_ nossa família temporária. Lá fizemos nosso tratamento e recebemos muito amor, carinho e cuidados \uD83E\uDD70 AUbrigado por tudinho, família temporária! Agora que estou saudável, estou prontinha para encher um lar de muuuito AUmor. Sou essa pretinha linda das fotos: carinhosa \uD83E\uDD0F\uD83C\uDFFC, companheira, amorosa e muito fiel. Prometo lambeijos para a vida toda e ser a melhor amiga do \uD83C\uDF0E!",
                "Marrua rei da criançada",
                R.drawable.pet_008,
                mutableListOf(
                    PetAttribute(PetAttributeKeyType.EnergyLevel,4),
                    PetAttribute(PetAttributeKeyType.Friendliness,2),
                    PetAttribute(PetAttributeKeyType.Playfulness,7),
                    PetAttribute(PetAttributeKeyType.Watchfulness,5)),
                OwnerPet("Lucas Motta", R.drawable.lucas),
                MutableLiveData(true),),
            )


    }

    fun loadPetFilters(): List<PetFilter>{
        return  listOf(
            PetFilter(PetTypeType.Cat, R.drawable.cat, false),
            PetFilter(PetTypeType.Dog, R.drawable.dog, false),
            PetFilter(PetTypeType.Panda, R.drawable.panda, false),
            PetFilter(PetTypeType.Rabbit, R.drawable.rabbit, false),
            PetFilter(PetTypeType.Seagull, R.drawable.seagull, false),
            PetFilter(PetTypeType.Mouse, R.drawable.mouse, false),
            PetFilter(PetTypeType.Elephant, R.drawable.elephant, false),
        )
    }

    fun loadSex(): List<Sex> {
        return listOf(
            Sex(1, SexType.Male, R.string.Male),
            Sex(2, SexType.Fermale, R.string.Fermale),
        )
    }

    fun loadAdoptionRequests(): List<AdoptionRequest> {
        return listOf(
            AdoptionRequest(1,
                Account("Letícia",
                    "Motta",
                    SexType.Fermale,
                    "lemotta@gmail.com",
                    "123",
                    R.drawable.woman,
                    false ),
                Pet("Belo Horizontal - MG",
                    PetTypeType.Dog,
                    "Marrua",
                    "",
                    10,
                    "Oi, eu sou a Marruá! \uD83E\uDD20\uD83D\uDC06 Vim aqui contar a minha história para vocês… minha mamãe Filó vivia no mato, próxima a uma fazenda e acabou engravidando de mim, e meus 9 AUirmãos. Depois que nascemos, ficamos todos abandonados nessa fazenda, vivendo em um pasto, até que as tias receberam nosso pedido de ajuda e correram para salvar todos nós! \uD83D\uDE4F\uD83C\uDFFB Chegando no projeto, passamos em consulta e fomos diagnosticados com Parvovirose. Fomos batizados com nomes dos personagens da novela Pantanal \uD83D\uDC06, sou a Marruá hihi. Depois, eu e meu AUirmão Levi fomos morar com @gabiiias e @duduoliveiira_ nossa família temporária. Lá fizemos nosso tratamento e recebemos muito amor, carinho e cuidados \uD83E\uDD70 AUbrigado por tudinho, família temporária! Agora que estou saudável, estou prontinha para encher um lar de muuuito AUmor. Sou essa pretinha linda das fotos: carinhosa \uD83E\uDD0F\uD83C\uDFFC, companheira, amorosa e muito fiel. Prometo lambeijos para a vida toda e ser a melhor amiga do \uD83C\uDF0E!",
                    "Marrua rei da criançada",
                    R.drawable.pet_008,
                    mutableListOf(
                        PetAttribute(PetAttributeKeyType.EnergyLevel,4),
                        PetAttribute(PetAttributeKeyType.Friendliness,2),
                        PetAttribute(PetAttributeKeyType.Playfulness,7),
                        PetAttribute(PetAttributeKeyType.Watchfulness,5)),
                    OwnerPet("Lucas Motta", R.drawable.lucas),
                    MutableLiveData(true),),
                )
        )
    }
}




